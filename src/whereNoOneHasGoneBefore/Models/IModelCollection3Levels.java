package whereNoOneHasGoneBefore.Models;

import java.util.Vector;

public interface IModelCollection3Levels<T extends ICloneable<T> & IModelCollection2Levels<T>> extends IModelCollection2Levels<T> {
	
	// Methods
	
	public void clearLevel2ModelsByIndex(int modelIndex, int level1ModelIndex);
	
	public void setLevel2ModelCollectionByIndex(int modelIndex, int level1ModelIndex, Vector<T> level2ModelsToClone);
	
	public void addLevel2ModelByIndex(int modelIndex, int level2ModelIndex, T level2Model);
	
	public void addLevel2ModelByIndex(int modelIndex, int level1ModelIndex, int level2ModelIndex, T level2Model);
	
	public void replaceLevel2ModelByIndex(int modelIndex, int level1ModelIndex, int level2ModelIndex, T level2Model);
	
	public void deleteLevel2ModelByIndex(int modelIndex, int level1ModelIndex, int level2ModelIndex);
		
	public String getLevel2NameByIndex(int modelIndex, int level1ModelIndex);
		
	public int getNumLevel2ModelsByIndex(int modelIndex, int level1ModelIndex);
	
	public T getLevel2ModelCloneByIndex(int modelIndex, int level1ModelIndex, int level2ModelIndex);
	
	public void setLevel2NameByIndex(int modelIndex, int level1ModelIndex, String name);	
}
