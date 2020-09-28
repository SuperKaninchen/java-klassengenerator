import java.util.List;
import java.util.ArrayList;

public class Generator {

  private String classTemplate = "\n"+
  "%isPrivate class %name {\n"+
  "%attribute\n"+
  "  %isPrivate %name(%parameter) {\n"+
  "  \n"+
  "  }\n"+
  "  %getter\n"+
  "  %setter\n"+
  "}\n"+
  "";

  private class Klasse {

    private String name;
    private boolean isPrivate;

    public List<Attribut> attribute;

    public Klasse() {
      attribute = new ArrayList<Attribut>();
    }
    public void setName(String pName) {
      name = pName;
    }
    public String getName() {
      return name;
    }
    public void setIsPrivate(boolean pIsPrivate) {
      isPrivate = pIsPrivate;
    }
    public boolean getIsPrivate() {
      return isPrivate;
    }
  }
  private class Attribut {
    public String name;
    public String type;
    public boolean isPrivate;
    public boolean hasSetter;
    public boolean hasGetter;
    public boolean inConstructor;
    private String attributeTemplate = "%isPrivate %type %name;";
    private String getterTemplate = "public %type get%Name() {\n" +
    "  return %name;\n" +
    "}";
    private String setterVorlage = "public void get%Name(%type p%Name) {\n" +
    "  %name = p%Name;\n" +
    "}";

    public Attribut(String pName, String pType, boolean pIsPrivate, boolean pHasSetter, boolean pHasGetter, boolean pInConstructor) {
      name = pName;
      type = pType;
      isPrivate = pIsPrivate;
      hasSetter = pHasSetter;
      hasGetter = pHasGetter;
      inConstructor = pInConstructor;
    }

    public String asString() {
      return attributeTemplate.replace("%name", name).replace("%type", type).replace("%isPrivate", Utils.boolToPString(isPrivate));
    }
    public String getGetterString() {
      return getterTemplate.replace("%type", type).replace("%Name", Utils.capitalize(name));
    }
    public Object[] asArray() {
      Object[] tmp = new Object[6];
      tmp[0] = name;
      tmp[1] = type;
      tmp[2] = isPrivate;
      tmp[3] = hasSetter;
      tmp[4] = hasGetter;
      tmp[5] = inConstructor;
      return tmp;
    }

  }

  Klasse k = new Klasse();

  Generator() {

  }

  public void updateKlasse(String pName, boolean pIsPrivate) {
    k.setName(pName);
    k.setIsPrivate(pIsPrivate);
  }

  private String getAttrString() {
    String str = "";
    for(int i = 0; i < k.attribute.size(); i++) {
      str += "  " + k.attribute.get(i).asString() + "\n";
    }
    return str;
  }
  private String getGetterString() {
    String str = "";
    for(int i = 0; i < k.attribute.size(); i++) {
      if(!k.attribute.get(i).isPrivate) {
        str += "  " + k.attribute.get(i).getGetterString() + "\n";
      }
    }
    return str;
  }

  public String klasseAlsString() {
    String tmp = classTemplate.replace("%isPrivate", Utils.boolToPString(k.getIsPrivate()));
    tmp = tmp.replace("%name", k.getName());
    tmp = tmp.replace("%attribute", getAttrString());
    tmp = tmp.replace("%getter", getGetterString());
    return tmp;
  }
  public void neuesAttribut() {
    k.attribute.add(new Attribut("null", "void", false, false, false, false));
  }
  public Object[] attributNamen() {
    if(k.attribute.size() <= 0)
      return null;
    List<String> tmp = new ArrayList<String>();
    for(Attribut a : k.attribute)
      tmp.add(a.name);
    return tmp.toArray();
  }
  public Object[] getAttrAsArray(int index) {
    return k.attribute.get(index).asArray();
  }

}
