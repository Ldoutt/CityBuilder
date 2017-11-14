/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citybuilder;

import java.util.ArrayList;

/**
 *
 * @author Lauren
 */
public class StructureCntl {

    private ArrayList<Structure> structures;
    private static StructureCntl structureCntl;

    public StructureCntl(ArrayList<Structure> structures) {
        this.structures = structures;

    }

    public void addStructure(Structure addStructure) {
        structures.add(addStructure);
    }

    public ArrayList<Structure> getStructureList() {
        return structures;
    }

    public static StructureCntl getStructureCntl() {
        if (structureCntl == null) {
            StructureCntl.structureCntl = new StructureCntl(new ArrayList<Structure>());
        }

        return structureCntl;
    }

    public void resetStructureArray() {
        structures = new ArrayList<Structure>();
    }

}
