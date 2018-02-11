package whereNoOneHasGoneBefore.Models;

import java.io.Serializable;
import java.util.Iterator;

public class Stage extends ModelCollection<Engine> implements Serializable, ICloneable<Stage>, IModelCollection<Engine> {

	// Constructors
	
	public Stage(String name, double dryMass, double totalMass, boolean engineMassIncludedInStageMass, boolean isMainStage, boolean canAerobrakeAtDestination,
			     boolean canLaunchAtDestination, boolean canLandAtDestination, boolean isReusable) {
		super(name);
		if (checkDryMassErrors(dryMass) || checkTotalMassErrors(dryMass, totalMass)) {
			throw new ArithmeticException("Stage.Stage: Invalid constructor parameters!");
		} else {
			m_dDryMass = dryMass;
			m_dTotalMass = totalMass;
			m_bEngineMassIncludedInStageMass = engineMassIncludedInStageMass;
			m_bIsMainStage = isMainStage;
			m_bIsSeperated = false;
			m_bCanAerobrakeAtDestination = canAerobrakeAtDestination; 
			m_bCanLaunchAtDestination = canLaunchAtDestination; 
			m_bCanLandAtDestination = canLandAtDestination;
			m_bIsReusable = isReusable; 
			performTasks();
		}
	}
	
	// Methods
		
	public Stage cloneObject() {
		Stage stage = new Stage(m_sName, m_dDryMass, m_dTotalMass, m_bEngineMassIncludedInStageMass, m_bIsMainStage, m_bCanAerobrakeAtDestination, 
				                m_bCanLaunchAtDestination, m_bCanLandAtDestination, m_bIsReusable);
		stage.setModelCollection(m_oModelCollection);
		stage.partialBurn(m_dBurnTimeLeft);
		stage.setIsSeperated(m_bIsSeperated);
		return stage;
	}
	
	public String getEngineNameByIndex(int engineIndex) {
		return m_oModelCollection.elementAt(engineIndex).getName();
	}
	
	public double getEngineMassByIndex(int engineIndex) {
		return m_oModelCollection.elementAt(engineIndex).getMass();
	}
	
	public double getEngineVacuumISPByIndex(int engineIndex) {
		return m_oModelCollection.elementAt(engineIndex).getVacuumISP();
	}
	
	public double getEngineVacuumThrustByIndex(int engineIndex) {
		return m_oModelCollection.elementAt(engineIndex).getVacuumThrust();
	}
		
	public double getDryMass() {
		if(m_bEngineMassIncludedInStageMass) {
			return m_dDryMass;
		} else {
			return m_dDryMassWithEngines;
		}
	}
	
	public double getCurrentTotalMass() {
		if(m_bEngineMassIncludedInStageMass) {
			return m_dTotalMass - m_dFuelMassBurned;
		} else {
			return m_dTotalMassWithEngines - m_dFuelMassBurned;
		}
	}
	
	public double getTotalVacuumThrust() {
		if(m_dBurnTimeLeft != 0) {
			return m_dTotalVacuumThrust; 
		}
		return 0;
	}
	
	public double getAverageVacuumISP() {
		if(m_dBurnTimeLeft != 0) {
			return m_dAverageVacuumISP; 
		}
		return 0;
	}	
	
	public double getBurnTimeLeft() {
		return m_dBurnTimeLeft;
	}
		
	public boolean getEngineMassIncludedInStageMass() {
		return m_bEngineMassIncludedInStageMass;
	}
	
	public boolean getIsMainStage() {
		return m_bIsMainStage;
	}
	
	public boolean getIsSeperated() {
		return m_bIsSeperated;
	}
	
	public boolean getCanAerobrakeAtDestination() {
		return m_bCanAerobrakeAtDestination;
	}
	
	public boolean getCanLaunchAtDestination() {
		return m_bCanLaunchAtDestination;
	}
	
	public boolean getCanLandAtDestination() {
		return m_bCanLandAtDestination;
	}
	
	public boolean getIsReusable() {
		return m_bIsReusable;
	}
				
	public void setEngineNameByIndex(int engineIndex, String name) {
		m_oModelCollection.elementAt(engineIndex).setName(name);
	}
	
	public void setEngineMassByIndex(int engineIndex, double mass) {
		m_oModelCollection.elementAt(engineIndex).setMass(mass);
		performTasks(false, true, false, true);
	}
	
	public void setEngineVacuumISPByIndex(int engineIndex, double vacuumISP) {
		m_oModelCollection.elementAt(engineIndex).setVacuumISP(vacuumISP);
		performTasks(true, false, true, true);
	}
	
	public void setEngineVacuumThrustByIndex(int engineIndex, double vacuumThrust) {
		m_oModelCollection.elementAt(engineIndex).setVacuumThrust(vacuumThrust);
		performTasks(true, false, true, true);
	}	
	
	public void setDryMass(double dryMass) {
		if (checkDryMassErrors(dryMass)) {
			throw new ArithmeticException("Stage.setDryMass: Invalid dryMass value!");
		} else {
			m_dDryMass = dryMass;
			performTasks(false, true, true, true);
		}
	}
	
	public void setTotalMass(double totalMass) {
		if (checkTotalMassErrors(totalMass, m_dDryMass)) {
			throw new ArithmeticException("Stage.setTotalMass: Invalid totalMass value!");
		} else {
			m_dTotalMass = totalMass;
			performTasks(false, true, true, true);
		}
	}
		
	public void setEngineMassIncludedInStageMass(boolean engineMassIncludedInStageMass) {
		m_bEngineMassIncludedInStageMass = engineMassIncludedInStageMass;
		performTasks(false, true, true, true);
	}
	
	public void setIsMainStage(boolean isMainStage) {
		m_bIsMainStage = isMainStage;
	}
		
	public void setIsSeperated(boolean isSeperated) {
		m_bIsSeperated = isSeperated;
	}
		
	public void setCanAerobrakeAtDestination(boolean canAerobrakeAtDestination) {
		m_bCanAerobrakeAtDestination = canAerobrakeAtDestination;
	}
	
	public void setCanLaunchAtDestination(boolean canLaunchAtDestination) {
		m_bCanLaunchAtDestination = canLaunchAtDestination;
	}
	
	public void setCanLandAtDestination(boolean canLandAtDestination) {
		m_bCanLandAtDestination = canLandAtDestination;
	}
	
	public void setIsReusable(boolean isReusable) {
		m_bIsReusable = isReusable;
	}
			
	public void resetBurnTime() {
		m_dBurnTimeLeft = m_dMaxBurnTime;
		m_bIsSeperated = false;
		m_dFuelMassBurned = 0;
	}
		
	public void partialBurn(double burnTime) {
		if(burnTime < 0 || burnTime > m_dBurnTimeLeft) {
			throw new ArithmeticException("Stage.partialBurn: Invalid burn time!");
		}
		m_dBurnTimeLeft -= burnTime;
		m_dFuelMassBurned = ((m_dTotalMass - m_dDryMass) * (m_dMaxBurnTime - m_dBurnTimeLeft)) / m_dMaxBurnTime; 
	}

	
	protected void performTasks() { 
		performTasks(true, true, true, true);
	}
	
	protected void performTasks(boolean calculateThrustAndISP, boolean calculateMass, boolean calculateMaxBurnTime, boolean resetBurnTime) { // Must be called in order
		// Must be called in order
		if(calculateThrustAndISP) { 
			calculateThrustAndISP();
		} 
		if(calculateMass) {
			calculateMass(); 
		}
		if(calculateMaxBurnTime) {
			calculateMaxBurnTime();
		}
		if(resetBurnTime) {
			resetBurnTime();
		}
	}
		
	private void calculateMass() {
		m_dTotalMassWithEngines = m_dTotalMass;
		m_dDryMassWithEngines = m_dDryMass;
	    Iterator<Engine> oIterator = m_oModelCollection.iterator();
		while(oIterator.hasNext()) {
			double engineMass = oIterator.next().getMass();
			m_dTotalMassWithEngines += engineMass;
			m_dDryMassWithEngines += engineMass;
		}
	}
		
	private void calculateThrustAndISP() {
		double totalThrust = 0;
		double totalThrustOverISP = 0;
		
		Iterator<Engine> iterator = m_oModelCollection.iterator();
		while(iterator.hasNext()) {
			Engine engine = iterator.next();
			totalThrust += engine.getVacuumThrust();
			totalThrustOverISP += engine.getVacuumThrust() / engine.getVacuumISP();
		}
		
		m_dTotalVacuumThrust = totalThrust;
		if(totalThrustOverISP == 0) {
			m_dAverageVacuumISP = 0;
		} else {
			m_dAverageVacuumISP = totalThrust / totalThrustOverISP;
		}
	}
	
	private boolean checkDryMassErrors(double dryMass) {
		return dryMass <= 0;
	}
	
	private boolean checkTotalMassErrors(double dryMass, double totalMass) {
		return totalMass < dryMass;
	}
	
	private void calculateMaxBurnTime() {
		m_dMaxBurnTime = (m_dTotalMass - m_dDryMass) / (m_dTotalVacuumThrust / (m_dAverageVacuumISP * Engine.STANDARD_GRAVITY)); // Fuel mass / mass flow rate
	}
		
	// Data members
	
	private static final long serialVersionUID = 1L; 
	
	private double m_dDryMass;
	private double m_dDryMassWithEngines;
	private double m_dTotalMass;
	private double m_dTotalMassWithEngines;
	private double m_dTotalVacuumThrust;
	private double m_dAverageVacuumISP;
	private double m_dMaxBurnTime; 
	private double m_dBurnTimeLeft; 
	private double m_dFuelMassBurned;
	private boolean m_bEngineMassIncludedInStageMass;
	private boolean m_bIsMainStage;
	private boolean m_bIsSeperated;
	private boolean m_bCanAerobrakeAtDestination; 
	private boolean m_bCanLaunchAtDestination; 
	private boolean m_bCanLandAtDestination;
	private boolean m_bIsReusable; 
}