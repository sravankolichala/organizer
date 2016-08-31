/**
 * 
 */
package com.skk.organizer.core;

import java.io.Serializable;
import java.time.Instant;

/**
 * @author Sravan Kumar Kolichala
 *
 */
public interface Organizable extends Serializable {
	
	Instant getStartTime();
	
	Person getOwner();

}
