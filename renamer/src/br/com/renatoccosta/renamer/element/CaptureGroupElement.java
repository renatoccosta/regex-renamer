package br.com.renatoccosta.renamer.element;

import java.io.File;

/**
 *
 * @author renato
 */
public class CaptureGroupElement extends Element {

    private String groupNumber;

    public CaptureGroupElement(String groupNumber) {
        this.groupNumber = groupNumber;
    }

    @Override
    public String getStringRepresentation(String srcName, File srcFile) {
        return "$" + groupNumber;
    }

    @Override
    public void setContent(String... groupNumber) {
        this.groupNumber = groupNumber[0];
    }

}
