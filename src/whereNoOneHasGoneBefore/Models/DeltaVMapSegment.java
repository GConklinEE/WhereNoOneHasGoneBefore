package whereNoOneHasGoneBefore.Models;

import java.io.Serializable;

public class DeltaVMapSegment implements Serializable, ICloneable<DeltaVMapSegment> {
	
	// Constructors
	
	public DeltaVMapSegment(String name, double deltaVOutgoingWithAeroBraking, double deltaVReturningWithAeroBraking, double deltaVOutgoingWithoutAeroBraking, double deltaVReturningWithoutAeroBraking, 
					        double groundLevelISPCorrectionFactorOutgoing, double groundLevelISPCorrectionFactorReturning, double deltaVToVacuumISPValidOutgoing, double deltaVToVacuumISPValidReturning,
					        double gravityAtDestination) {
		if(deltaVOutgoingWithAeroBraking <= 0 || deltaVReturningWithAeroBraking <= 0 || deltaVOutgoingWithoutAeroBraking <= 0 || deltaVReturningWithoutAeroBraking <= 0 || m_dGroundLevelISPCorrectionFactorOutgoing <= 0 || 
		   m_dGroundLevelISPCorrectionFactorOutgoing > MAX_GROUND_LEVEL_ISP_CORRECTION_FACTOR || m_dGroundLevelISPCorrectionFactorReturning <= 0 || m_dGroundLevelISPCorrectionFactorReturning > MAX_GROUND_LEVEL_ISP_CORRECTION_FACTOR || 
		   m_dDeltaVToVacuumISPValidOutgoing < 0 || m_dDeltaVToVacuumISPValidReturning < 0 || gravityAtDestination < 0) {
			throw new ArithmeticException("DeltaVMapSegment.DeltaVMapSegment: Invalid constructor parameters!");
		} else {
			m_sName = name;
			m_dGravityAtDestination = gravityAtDestination;
			m_dDeltaVOutgoingWithAeroBraking = deltaVOutgoingWithAeroBraking;
			m_dDeltaVReturningWithAeroBraking = deltaVReturningWithAeroBraking;
			m_dDeltaVOutgoingWithoutAeroBraking = deltaVOutgoingWithoutAeroBraking;
			m_dDeltaVReturningWithoutAeroBraking = deltaVReturningWithoutAeroBraking;
			m_dGroundLevelISPCorrectionFactorOutgoing = groundLevelISPCorrectionFactorOutgoing;
			m_dGroundLevelISPCorrectionFactorReturning = groundLevelISPCorrectionFactorReturning;
			m_dDeltaVToVacuumISPValidOutgoing = deltaVToVacuumISPValidOutgoing;
			m_dDeltaVToVacuumISPValidReturning = deltaVToVacuumISPValidReturning;
		}
	}
	
	// Methods
	
	public DeltaVMapSegment cloneObject() {
		DeltaVMapSegment deltaVMapSegment = new DeltaVMapSegment(m_sName, m_dDeltaVOutgoingWithAeroBraking, m_dDeltaVReturningWithAeroBraking, m_dDeltaVOutgoingWithoutAeroBraking, m_dDeltaVReturningWithoutAeroBraking, 
				                                                 m_dGroundLevelISPCorrectionFactorOutgoing, m_dGroundLevelISPCorrectionFactorReturning, m_dDeltaVToVacuumISPValidOutgoing, m_dDeltaVToVacuumISPValidReturning,
				                                                 m_dGravityAtDestination);
		deltaVMapSegment.setMaxPayload(m_dMaxPayloadOutgoing, true);
		deltaVMapSegment.setMaxPayload(m_dMaxPayloadReturning, false);
		
		return deltaVMapSegment;
	}
	
	public String getName() {
		return m_sName;
	}
	
	public double getGravityAtDestination() {
		return m_dGravityAtDestination;
	}
	
	public double getDeltaV(boolean outgoing, boolean aerobraking) {
		if(outgoing && aerobraking) {
			return m_dDeltaVOutgoingWithAeroBraking;
		} else if (outgoing && !aerobraking) {
			return m_dDeltaVOutgoingWithoutAeroBraking;
		} else if (!outgoing && aerobraking) {
			return m_dDeltaVReturningWithAeroBraking;
		}
		return m_dDeltaVReturningWithoutAeroBraking;
	}
	
	public double getGroundLevelISPCorrectionFactor(boolean outgoing) {
		if(outgoing) {
			return m_dGroundLevelISPCorrectionFactorOutgoing;
		}
		return m_dGroundLevelISPCorrectionFactorReturning;
	}
	
	public double getDeltaVToVacuumISPValid(boolean outgoing) {
		if(outgoing) {
			return m_dDeltaVToVacuumISPValidOutgoing;
		}
		return m_dDeltaVToVacuumISPValidReturning;
	}
	
	public double getMaxPayload(boolean outgoing) {
		if(outgoing) {
			return m_dMaxPayloadOutgoing;
		} 
		return m_dMaxPayloadReturning;
	}
	
	public void setMaxPayload(double maxPayload, boolean outgoing) {
		if(maxPayload < 0 ) {
			throw new ArithmeticException("DeltaVMapSegment.setMaxPayload: Invalid maxPayload value!");
		} else {
			if(outgoing) {
				m_dMaxPayloadOutgoing = maxPayload;
			} else {
				m_dMaxPayloadReturning = maxPayload;
			}
		}
	}
	
	// Data members
	
	public static final double STANDARD_GRAVITY = 9.80665; // m/s^2 	
	private static final double MAX_GROUND_LEVEL_ISP_CORRECTION_FACTOR= 1;
	private static final long serialVersionUID = 1L; 
	
	private String m_sName;
	private double m_dGravityAtDestination;
	private double m_dDeltaVOutgoingWithAeroBraking;
	private double m_dDeltaVReturningWithAeroBraking;
	private double m_dDeltaVOutgoingWithoutAeroBraking;
	private double m_dDeltaVReturningWithoutAeroBraking;
	private double m_dGroundLevelISPCorrectionFactorOutgoing; // (0-1], 1 = vacuum
	private double m_dGroundLevelISPCorrectionFactorReturning; // (0-1], 1 = vacuum
	private double m_dDeltaVToVacuumISPValidOutgoing; 
	private double m_dDeltaVToVacuumISPValidReturning; 
	private double m_dMaxPayloadOutgoing;
	private double m_dMaxPayloadReturning;
}
