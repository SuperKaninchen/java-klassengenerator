import java.util.List;

public class Generator {
  
  private String klassenVorlage = "\n"+
  "%isPrivate class %name {\n"+
  "  %attribute;\n"+
  "  %isPrivate %name() {\n"+
  "  \n"+  
  "  }\n"+
  "  %getterAndSetter\n"+
  "}\n"+
  "";

  private class Klasse {
    
    private String name;
    private boolean isPrivate;
    
    private List<String> attrName;
    private List<String> attrTyp;
    private List<Boolean> attrPrivate;
    private List<Boolean> attrHatSetter;
    private List<Boolean> attrHatGetter;
    
    public Klasse(/*List<String> pAttrName, List<String> pAttrTyp,
                  List<Boolean> pAttrPublic, List<Boolean> pAttrHatSetter,
                  List<Boolean> pAttrHatGetter*/) {
      /*attrName = pAttrName;
      attrTyp = pAttrTyp;
      attrPublic = pAttrPublic;
      attrHatSetter = pAttrHatSetter;
      attrHatGetter = pAttrHatGetter*/;
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
  
  private String boolAsString(boolean pBool) {
    if(pBool)
      return "private";
    else
      return "public";
  }
  
  public String klasseAlsString() {
    String tmp = klassenVorlage.replace("%isPrivate", boolAsString(k.getIsPrivate()));
    tmp = tmp.replace("%name", k.getName());
    return tmp;
  }
  
}
