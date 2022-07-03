package com.capgemini.pcshop.repository;

import com.capgemini.pcshop.data.Part;
import org.apache.geode.cache.Region;
import org.apache.geode.cache.RegionExistsException;
import org.apache.geode.cache.client.ClientCache;
import org.apache.geode.cache.client.ClientCacheFactory;
import org.apache.geode.cache.client.ClientRegionShortcut;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class PcPartsRepositoryGeode implements PcPartsRepository {

    private Region<Integer, Part> region;
    List<Part> parts = new ArrayList<Part>() {{
        add(new Part(1, "Laptop", "48239523"));
        add(new Part(2, "Keyboard", "2382234"));
        add(new Part(3, "Mouse", "48239523"));
        add(new Part(4, "Headphones", "2382234"));
        add(new Part(5, "Monitor", "48239523"));
        add(new Part(6, "Memory stick", "2382234"));
    }};
    List<Integer> keys = parts.stream().map(Part::getPartId).collect(Collectors.toList());

    @PostConstruct
    private void initRepository() {
        connectToGeode();
        addPartsToGeode();
    }

    private void connectToGeode() {
        ClientCache cache = new ClientCacheFactory()
                .addPoolLocator("localhost", 10334)
                .create();

        try {
            region = cache.<Integer, Part>createClientRegionFactory(ClientRegionShortcut.CACHING_PROXY).create("psshop-region");
        } catch (RegionExistsException exception) {
            region = cache.getRegion("psshop-region");
        }

    }

    private void addPartsToGeode() {
        Map<Integer, Part> mapOfParts = parts
                .stream()
                .collect(Collectors.toMap(Part::getPartId, Function.identity()));

        region.putAll(mapOfParts);
    }


    @Override
    public List<Part> findAllParts() {
        return new ArrayList<>(region.getAll(keys).values());
    }

    @Override
    public Part findByPartId(int partId) {
        return region.get(partId);
    }
}
