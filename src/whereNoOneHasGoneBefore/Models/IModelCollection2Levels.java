package whereNoOneHasGoneBefore.Models;

import java.util.Vector;

public interface IModelCollection2Levels<T extends ICloneable<T> & IModelCollection<T>> extends IModelCollection<T> {
	
	// Methods
	
	public void clearLevel1ModelsByIndex(int modelIndex);
	
	public void setLevel1ModelCollectionByIndex(int modelIndex, Vector<T> level1ModelsToClone); 
	
	public void addLevel1ModelByIndex(int modelIndex, T level1Model); 
	
	public void addLevel1ModelByIndex(int modelIndex, int level1ModelIndex, T level1Model); 
	
	public void replaceLevel1ModelByIndex(int modelIndex, int level1ModelIndex, T level1Model); 
	
	public void deleteLevel1ModelByIndex(int modelIndex, int level1ModelIndex); 
		
	public String getLevel1NameByIndex(int modelIndex); 
		
	public int getNumLevel1ModelsByIndex(int modelIndex); 
	
	public T getLevel1ModelCloneByIndex(int modelIndex, int index); 
	
	public void setLevel1NameByIndex(int modelIndex, String name);
}
