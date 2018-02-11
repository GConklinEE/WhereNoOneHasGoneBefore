package whereNoOneHasGoneBefore.Models;

import java.util.Vector;

public abstract class ModelCollection3Levels<T extends ICloneable<T> & IModelCollection2Levels<T>> extends ModelCollection2Levels<T> implements IModelCollection3Levels<T> {
	
	// Constructors
	
	public ModelCollection3Levels(String name) {
		super(name);
	}
	
	// Methods
		
	public void clearLevel2ModelsByIndex(int modelIndex, int level1ModelIndex) {
		m_oModelCollection.elementAt(modelIndex).clearLevel1ModelsByIndex(level1ModelIndex);
		performTasks();
	}
	
	public void setLevel2ModelCollectionByIndex(int modelIndex, int level1ModelIndex, Vector<T> level2ModelsToClone) {
		m_oModelCollection.elementAt(modelIndex).setLevel1ModelCollectionByIndex(level1ModelIndex, level2ModelsToClone);
		performTasks();
	}
	
	public void addLevel2ModelByIndex(int modelIndex, int level2ModelIndex, T level2Model) {
		addLevel2ModelByIndex(modelIndex, m_oModelCollection.elementAt(modelIndex).getNumLevel1ModelsByIndex(modelIndex), level2ModelIndex, level2Model);
	}
	
	public void addLevel2ModelByIndex(int modelIndex, int level1ModelIndex, int level2ModelIndex, T level2Model) {
		m_oModelCollection.elementAt(modelIndex).addLevel1ModelByIndex(level1ModelIndex, level2ModelIndex, level2Model.cloneObject());
		performTasks();
	}
	
	public void replaceLevel2ModelByIndex(int modelIndex, int level1ModelIndex, int level2ModelIndex, T level2Model) {
		m_oModelCollection.elementAt(modelIndex).replaceLevel1ModelByIndex(level1ModelIndex, level2ModelIndex, level2Model.cloneObject());
		performTasks();
	}
	
	public void deleteLevel2ModelByIndex(int modelIndex, int level1ModelIndex, int level2ModelIndex) {
		m_oModelCollection.elementAt(modelIndex).deleteLevel1ModelByIndex(level1ModelIndex, level2ModelIndex);
		performTasks();
	}	
		
	public String getLevel2NameByIndex(int modelIndex, int level1ModelIndex) {
		return m_oModelCollection.elementAt(modelIndex).getLevel1NameByIndex(level1ModelIndex);
	}
		
	public int getNumLevel2ModelsByIndex(int modelIndex, int level1ModelIndex) {
		return m_oModelCollection.elementAt(modelIndex).getNumLevel1ModelsByIndex(level1ModelIndex);
	}
	
	public T getLevel2ModelCloneByIndex(int modelIndex, int level1ModelIndex, int level2ModelIndex) {
		return m_oModelCollection.elementAt(modelIndex).getLevel1ModelCloneByIndex(level1ModelIndex, level2ModelIndex);
	}
	
	public void setLevel2NameByIndex(int modelIndex, int level1ModelIndex, String name) {
		m_oModelCollection.elementAt(modelIndex).setLevel1NameByIndex(level1ModelIndex, name);
	}		
}
