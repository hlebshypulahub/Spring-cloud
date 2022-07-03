package com.capgemini.pcshop.data;


import java.io.Serializable;

public class Part implements Serializable {
    private int partId;
    private String partName;
    private String producerCode;

    public Part(int Id, String name, String producerCode) {
        this.partId = Id;
        this.partName = name;
        this.producerCode = producerCode;
    }

    public String getName() {
        return partName;
    }

    public String getProducerCode() {
        return producerCode;
    }

    public int getPartId() {
        return partId;
    }

    public void setPartId(int partId) {
        this.partId = partId;
    }

    public String getPartName() {
        return partName;
    }

    public void setPartName(String partName) {
        this.partName = partName;
    }

    public void setProducerCode(String producerCode) {
        this.producerCode = producerCode;
    }
}
