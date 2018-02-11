package whereNoOneHasGoneBefore.Models;

import java.util.Vector;

public interface IModelCollection<T extends ICloneable<T>> {
	
	// Methods
		
	public void clearModels();
	
	public void setModelCollection(Vector<T> modelsToClone);
	
	public void addModel(T model);
	
	public void addModel(int index, T model);
	
	public void replaceModel(int index, T model);
	
	public void deleteModel(int index);
		
	public String getName();
		
	public int getNumModels();
	
	public T getModelClone(int index);
	
	public void setName(String name);
}
