package com.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Tr {

    private String text;
    private String pos;
    private List<Mean> mean = new ArrayList<Mean>();
    private List<Ex> ex = new ArrayList<Ex>();
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     *
     * @return
     * The text
     */
    public String getText() {
        return text;
    }

    /**
     *
     * @param text
     * The text
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     *
     * @return
     * The pos
     */
    public String getPos() {
        return pos;
    }

    /**
     *
     * @param pos
     * The pos
     */
    public void setPos(String pos) {
        this.pos = pos;
    }

    /**
     *
     * @return
     * The mean
     */
    public List<Mean> getMean() {
        return mean;
    }

    /**
     *
     * @param mean
     * The mean
     */
    public void setMean(List<Mean> mean) {
        this.mean = mean;
    }

    /**
     *
     * @return
     * The ex
     */
    public List<Ex> getEx() {
        return ex;
    }

    /**
     *
     * @param ex
     * The ex
     */
    public void setEx(List<Ex> ex) {
        this.ex = ex;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
