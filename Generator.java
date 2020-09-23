import java.util.List;
import java.util.ArrayList;

public class Generator {

  private String klassenVorlage = "\n"+
  "%isPrivate class %name {\n"+
  "  %attribute\n"+
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
      str += k.attribute.get(i).asString() + "\n";
    }
    return str;
  }
  private String getGetterString() {
    String str = "";
    for(int i = 0; i < k.attribute.size(); i++) {
      if(!k.attribute.get(i).privat) {
        str += k.attribute.get(i).getGetterString() + "\n";
      }
    }
    return str;
  }

  public String klasseAlsString() {
    String tmp = klassenVorlage.replace("%isPrivate", Utils.boolToPString(k.getIsPrivate()));
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
  public Attribut getAttr(int index) {
    return k.attribute.get(index);
  }

}
