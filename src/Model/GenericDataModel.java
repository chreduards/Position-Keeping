package Model;

// En generisk klass då flera tabeller i nuvarande utförande endast är uppbyggda av ett id och namn.
public class GenericDataModel {
    
    private int id;
    private String name;
    
    public GenericDataModel(int id, String name){
        
        setId(id);
        setName(name);
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
