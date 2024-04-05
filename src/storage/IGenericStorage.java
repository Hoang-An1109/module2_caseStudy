package storage;

import java.util.List;

public interface IGenericStorage<IGeneric> {
    void writeFile(List<IGeneric> productCategory);
    List<IGeneric> readFile();
}
