package whereNoOneHasGoneBefore.Models;

import java.io.Serializable;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class StageGroup extends ModelCollection2Levels<Stage> implements Serializable, ICloneable<StageGroup> {

	// Constructors
	
	public StageGroup(String name) {
		super(name);
		m_iMainStageIndex = -1;
		
	}
	
	// Methods
		
	public StageGroup cloneObject() {
		StageGroup stageGroup = new StageGroup(m_sName);
		stageGroup.setModelCollection(m_oModelCollection);
		return stageGroup;
	}
	
	get num stages and engines
	get stage names by index
		
	public String getEngineNameByIndex(int stageIndex, int engineIndex) {
		return m_oModelCollection.elementAt(stageIndex).getEngineNameByIndex(engineIndex);
	}
	
	public double getEngineMassByIndex(int stageIndex, int engineIndex) {
		return m_oModelCollection.elementAt(stageIndex).getEngineMassByIndex(engineIndex);
	}
	
	public double getEngineVacuumISPByIndex(int stageIndex, int engineIndex) {
		return m_oModelCollection.elementAt(stageIndex).getEngineVacuumISPByIndex(engineIndex);
	}
	
	public double getEngineVacuumThrustByIndex(int stageIndex, int engineIndex) {
		return m_oModelCollection.elementAt(stageIndex).getEngineVacuumThrustByIndex(engineIndex);
	}
		
	public double getStageDryMassByIndex(int stageIndex) {
		return m_oModelCollection.elementAt(stageIndex).getDryMass();
	}
	
	public double getStageCurrentTotalMassByIndex(int stageIndex) {
		return m_oModelCollection.elementAt(stageIndex).getCurrentTotalMass();
	}
	
	public double getStageTotalVacuumThrustByIndex(int stageIndex) {
		return m_oModelCollection.elementAt(stageIndex).getTotalVacuumThrust();
	}
	
	public double getStageAverageVacuumISPByIndex(int stageIndex) {
		return m_oModelCollection.elementAt(stageIndex).getAverageVacuumISP();
	}	
	
	public double getBurnTimeLeftByIndex(int stageIndex) {
		return m_oModelCollection.elementAt(stageIndex).getBurnTimeLeft();
	}
		
	public boolean getEngineMassIncludedInStageMassByIndex(int stageIndex) {
		return m_oModelCollection.elementAt(stageIndex).getEngineMassIncludedInStageMass();
	}
	
	public boolean getIsMainStageByIndex(int stageIndex) {
		return m_oModelCollection.elementAt(stageIndex).getIsMainStage();
	}
	
	public boolean getIsSeperatedByIndex(int stageIndex) {
		return m_oModelCollection.elementAt(stageIndex).getIsSeperated();
	}
	
	public boolean getCanAerobrakeAtDestinationByIndex(int stageIndex) {
		return m_oModelCollection.elementAt(stageIndex).getCanAerobrakeAtDestination();
	}
	
	public boolean getCanLaunchAtDestinationByIndex(int stageIndex) {
		return m_oModelCollection.elementAt(stageIndex).getCanLaunchAtDestination();
	}
	
	public boolean getCanLandAtDestinationByIndex(int stageIndex) {
		return m_oModelCollection.elementAt(stageIndex).getCanLandAtDestination();
	}
	
	public boolean getIsReusableByIndex(int stageIndex) {
		return m_oModelCollection.elementAt(stageIndex).getIsReusable();
	}
	
	public int getMainStageIndex() {
		return m_iMainStageIndex;
	}
	
	public double getCurrentStageGroupTotalMass() {
		double stageGroupTotalMass = 0;
		Iterator<Stage> stages = m_oModelCollection.iterator();
	    while(stages.hasNext()) {
	    	Stage stage = stages.next();
	    	if(!stage.getIsSeperated()) {
	    		stageGroupTotalMass += stage.getCurrentTotalMass();
	    	}
	    }
	    return stageGroupTotalMass;
	}

	public double getCurrentStageGroupTotalVacuumThrust() {
		double stageGroupTotalVacuumThrust = 0;
		Iterator<Stage> stages = m_oModelCollection.iterator();
	    while(stages.hasNext()) {
	    	Stage stage = stages.next();
	    	if(!stage.getIsSeperated()) {
	    		stageGroupTotalVacuumThrust += stage.getTotalVacuumThrust();
	    	}
	    }
	    return stageGroupTotalVacuumThrust;
	}
	
	public double getCurrentStageGroupAverageVacuumISP() {
		double stageGroupTotalVacuumThrust = 0;
		double stageGroupAverageVacuumISPDenominator = 0;
		Iterator<Stage> stages = m_oModelCollection.iterator();
	    while(stages.hasNext()) {
	    	Stage stage = stages.next();
	    	if(!stage.getIsSeperated()) {
	    		stageGroupTotalVacuumThrust += stage.getTotalVacuumThrust();
	    		stageGroupAverageVacuumISPDenominator += stage.getTotalVacuumThrust() / stage.getAverageVacuumISP();
	    	}
	    }
	    return stageGroupTotalVacuumThrust / stageGroupAverageVacuumISPDenominator;
	}
				
	public void setEngineNameByIndex(int stageIndex, int engineIndex, String name) {
		m_oModelCollection.elementAt(stageIndex).setName(name);
	}
	
	public void setEngineMassByIndex(int stageIndex, int engineIndex, double mass) {
		m_oModelCollection.elementAt(stageIndex).setEngineMassByIndex(engineIndex, mass);
		resetStageBurnTimes();
	}
	
	public void setEngineVacuumISPByIndex(int stageIndex, int engineIndex, double vacuumISP) {
		m_oModelCollection.elementAt(stageIndex).setEngineVacuumISPByIndex(engineIndex, vacuumISP);
		resetStageBurnTimes();
	}
	
	public void setEngineVacuumThrustByIndex(int stageIndex, int engineIndex, double vacuumThrust) {
		m_oModelCollection.elementAt(stageIndex).setEngineVacuumThrustByIndex(engineIndex, vacuumThrust);
		resetStageBurnTimes();
	}	
	
	public void setStageDryMassByIndex(int stageIndex, double dryMass) {
		m_oModelCollection.elementAt(stageIndex).setDryMass(dryMass);
		resetStageBurnTimes();
	}
	
	public void setStageTotalMassByIndex(int stageIndex, double totalMass) {
		m_oModelCollection.elementAt(stageIndex).setTotalMass(totalMass);
		resetStageBurnTimes();
	}
		
	public void setEngineMassIncludedInStageMassByIndex(int stageIndex, boolean engineMassIncludedInStageMass) {
		m_oModelCollection.elementAt(stageIndex).setEngineMassIncludedInStageMass(engineMassIncludedInStageMass);
		resetStageBurnTimes();
	}
	
	public void seperateStageByIndex(int stageIndex) {
		m_oModelCollection.elementAt(stageIndex).setIsSeperated(true);
		if(m_oModelCollection.elementAt(stageIndex).getIsMainStage()) {
			Iterator<Stage> stages = m_oModelCollection.iterator();
		    while(stages.hasNext()) {
		    	Stage stage = stages.next();
		    	stage.setIsSeperated(true);
		    }
		}
	}
	
	public void setCanAerobrakeAtDestinationByIndex(int stageIndex, boolean canAerobrakeAtDestination) {
		m_oModelCollection.elementAt(stageIndex).setCanAerobrakeAtDestination(canAerobrakeAtDestination);
		resetStageBurnTimes();
	}
	
	public void setCanLaunchAtDestinationByIndex(int stageIndex, boolean canLaunchAtDestination) {
		m_oModelCollection.elementAt(stageIndex).setCanLaunchAtDestination(canLaunchAtDestination);
		resetStageBurnTimes();
	}
	
	public void setCanLandAtDestinationByIndex(int stageIndex, boolean canLandAtDestination) {
		m_oModelCollection.elementAt(stageIndex).setCanLaunchAtDestination(canLandAtDestination);
		resetStageBurnTimes();
	}
	
	public void setIsReusableByIndex(int stageIndex, boolean isReusable) {
		m_oModelCollection.elementAt(stageIndex).setCanLaunchAtDestination(isReusable);
		resetStageBurnTimes();
	}
			
	public void resetStageBurnTimes() {
		Iterator<Stage> stages = m_oModelCollection.iterator();
	    while(stages.hasNext()) {
	    	stages.next().resetBurnTime();
	    }
	}
		
	public void partialBurnAllAttachedStages(double burnTime) {
		Iterator<Stage> stages = m_oModelCollection.iterator();
	    while(stages.hasNext()) {
	    	Stage stage = stages.next();
	    	if(!stage.getIsSeperated()) {
	    		stage.partialBurn(burnTime);
	    	}
	    }
	}
	
	protected void performTasks() {
		resetStageBurnTimes();
		findMainStageIndex();
	}
	
	private void findMainStageIndex() {
		boolean mainStageFound = false;
		boolean multipleMainStagesFound = false;
		for(int mainStageIndex = 0; mainStageIndex < m_oModelCollection.size(); mainStageIndex++) {
			if(m_oModelCollection.elementAt(mainStageIndex).getIsMainStage()) {
				if(!mainStageFound) {
					m_iMainStageIndex = mainStageIndex;
					mainStageFound = true;
				} else {
					multipleMainStagesFound = true;
					break;
				}
	    	}
		}
		if(!mainStageFound) {
			m_iMainStageIndex = -1;
			if(m_oModelCollection.size() != 0) {
				throw new NoSuchElementException("StageGroup.findMainStageIndex: The stage group is not empty, but there is no main stage present! A main stage must always be present in a non-empty stage group.");
			}
		} else if (multipleMainStagesFound) {
			throw new IllegalArgumentException("StageGroup.findMainStageIndex: The stage group has multiple main stages! Only one main stage is allowed in a stage group.");
		}
	}
	
	// Data members
	
	private static final long serialVersionUID = 1L; 
	
	private int m_iMainStageIndex;
}
