package master.types;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.*;

@XmlType(name = "", propOrder = {
    "masterType"
})
@XmlRootElement(name = "MasterListType")
public class MasterListType {

    @XmlElement(name = "MasterType")
    protected List<MasterType> masterType;
 
    public List<MasterType> getBookType() {
        if (masterType == null) {
        	masterType = new ArrayList<MasterType>();
        }
        return this.masterType;
    }
}
