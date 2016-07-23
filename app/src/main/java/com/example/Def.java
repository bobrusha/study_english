package com.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Andrey on 23.07.2016.
 */

public class Def {

    private String text;
    private String pos;
    private String ts;
    private List<Tr> tr = new ArrayList<Tr>();
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
     * The ts
     */
    public String getTs() {
        return ts;
    }

    /**
     *
     * @param ts
     * The ts
     */
    public void setTs(String ts) {
        this.ts = ts;
    }

    /**
     *
     * @return
     * The tr
     */
    public List<Tr> getTr() {
        return tr;
    }

    /**
     *
     * @param tr
     * The tr
     */
    public void setTr(List<Tr> tr) {
        this.tr = tr;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}


