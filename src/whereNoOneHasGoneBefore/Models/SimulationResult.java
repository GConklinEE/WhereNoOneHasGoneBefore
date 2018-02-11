package whereNoOneHasGoneBefore.Models;

import java.io.Serializable;

public class SimulationResult implements Serializable {
	
	// Constructors
	
	public SimulationResult(String destinationName) {
		m_sDestinationName = destinationName;
	}
	
	// Methods
	
	public String getDestinationName() {
		return m_sDestinationName;
	}
	
	public double getMaxPayload(boolean outgoing) {
		if(outgoing) {
			return m_dMaxPayloadOutgoing;
		} 
		return m_dMaxPayloadReturning;
	}
	
	public void setMaxPayload(double maxPayload, boolean outgoing) {
		if(maxPayload < 0 ) {
			throw new ArithmeticException("SimulationResults.setMaxPayload: Invalid maxPayload value!");
		} else {
			if(outgoing) {
				m_dMaxPayloadOutgoing = maxPayload;
			} else {
				m_dMaxPayloadReturning = maxPayload;
			}
		}
	}
	
	// Data members
	
	private static final long serialVersionUID = 1L; 
	
	private String m_sDestinationName;
	private double m_dMaxPayloadOutgoing;
	private double m_dMaxPayloadReturning;
}