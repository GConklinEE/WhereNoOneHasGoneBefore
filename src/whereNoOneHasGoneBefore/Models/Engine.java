package whereNoOneHasGoneBefore.Models;

import java.io.Serializable;

public class Engine implements Serializable{

	// Constructors
	
	public Engine(String name, double mass, double vacuumISP, double vacuumThrust) {
		if(checkVacuumISPErrors(vacuumISP) || checkMassErrors(mass) || checkVacuumThrustErrors(vacuumThrust)) {
			throw new ArithmeticException("Engine.Engine: Invalid constructor parameters!");
		} else {
			m_sName = name;
			m_dMass = mass;	
			m_dVacuumISP = vacuumISP;
			m_dVacuumThrust = vacuumThrust;
		}
	}
	
	// Methods

	public String getName() {
		return m_sName;
	}
	
	public double getMass() {
		return m_dMass;
	}
	
	public double getVacuumISP() {
		return m_dVacuumISP;
	}
	
	public double getVacuumThrust() {
		return m_dVacuumThrust;
	}
	
	public void setName(String name) {
		m_sName = name;
	}
	
	public void setMass(double mass) {
		if(checkMassErrors(mass)) {
			throw new ArithmeticException("Engine.setMass: Invalid mass value!");
		} else {
			m_dMass = mass;
		}
	}
	
	public void setVacuumISP(double vacuumISP) {
		if(checkVacuumISPErrors(vacuumISP)) {
			throw new ArithmeticException("Engine.setVacuumISP: Invalid vacuumISP value!");
		} else {
			m_dVacuumISP = vacuumISP;
		}
	}
	
	public void setVacuumThrust(double vacuumThrust) {
		if(checkVacuumThrustErrors(vacuumThrust)) {
			throw new ArithmeticException("Engine.setVacuumThrust: Invalid vacuumThrust value!");
		} else {
			m_dVacuumThrust = vacuumThrust;
		}
	}	
	
	private boolean checkMassErrors(double mass) {
		return mass < 0;
	}
	
	private boolean checkVacuumISPErrors(double vacuumISP) {
		return vacuumISP <= 0;
	}
	
	private boolean checkVacuumThrustErrors(double vacuumThrust) {
		return vacuumThrust < 0;
	}
	
	// Data members
		
	private static final long serialVersionUID = 1L; 
	public static final double STANDARD_GRAVITY = 9.80665; // m/s^2 	
		
	private String m_sName;
	private double m_dMass; // Kg, can be zero if included in stage mass
	private double m_dVacuumISP; // s
	private double m_dVacuumThrust; // N
}
