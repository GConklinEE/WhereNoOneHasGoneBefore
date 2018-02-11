package whereNoOneHasGoneBefore.Models;

import java.util.Vector;

public abstract class ModelCollection2Levels<T extends ICloneable<T> & IModelCollection<T>> extends ModelCollection<T> implements IModelCollection2Levels<T> {
	
	// Constructors
	
	public ModelCollection2Levels(String name) {
		super(name);
	}
	
	// Methods
		
	public void clearLevel1ModelsByIndex(int modelIndex) {
		m_oModelCollection.elementAt(modelIndex).clearModels();
		performTasks();
	}
	
	public void setLevel1ModelCollectionByIndex(int modelIndex, Vector<T> level1ModelsToClone) {
		m_oModelCollection.elementAt(modelIndex).setModelCollection(level1ModelsToClone);
		performTasks();
	}
	
	public void addLevel1ModelByIndex(int modelIndex, T level1Model) {
		addLevel1ModelByIndex(modelIndex, m_oModelCollection.elementAt(modelIndex).getNumModels(), level1Model);
	}
	
	public void addLevel1ModelByIndex(int modelIndex, int level1ModelIndex, T level1Model) {
		m_oModelCollection.elementAt(modelIndex).addModel(level1ModelIndex, level1Model.cloneObject());
		performTasks();
	}
	
	public void replaceLevel1ModelByIndex(int modelIndex, int level1ModelIndex, T level1Model) {
		m_oModelCollection.elementAt(modelIndex).replaceModel(level1ModelIndex, level1Model.cloneObject());
		performTasks();
	}
	
	public void deleteLevel1ModelByIndex(int modelIndex, int level1ModelIndex) {
		m_oModelCollection.elementAt(modelIndex).deleteModel(level1ModelIndex);
		performTasks();
	}	
		
	public String getLevel1NameByIndex(int modelIndex) {
		return m_oModelCollection.elementAt(modelIndex).getName();
	}
		
	public int getNumLevel1ModelsByIndex(int modelIndex) {
		return m_oModelCollection.elementAt(modelIndex).getNumModels();
	}
	
	public T getLevel1ModelCloneByIndex(int modelIndex, int level1ModelIndex) {
		return m_oModelCollection.elementAt(modelIndex).getModelClone(level1ModelIndex);
	}
	
	public void setLevel1NameByIndex(int modelIndex, String name) {
		m_oModelCollection.elementAt(modelIndex).setName(name);
	}		
}
