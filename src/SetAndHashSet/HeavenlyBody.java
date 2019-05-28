package SetAndHashSet;

import java.util.HashSet;
import java.util.Set;

public final class HeavenlyBody {
	
	private String name;
	private double orbintalPeriod;
	private Set<HeavenlyBody> satellites;
	
	public HeavenlyBody(String name, double orbintalPeriod) {
		this.name = name;
		this.orbintalPeriod = orbintalPeriod;
		this.satellites = new HashSet<>();
	}

	public String getName() {
		return name;
	}

	public double getOrbintalPeriod() {
		return orbintalPeriod;
	}
	
	public boolean addMoon(HeavenlyBody moon) {
		return this.satellites.add(moon);	
	}

	public Set<HeavenlyBody> getSatellites() {
		return new HashSet<>(this.satellites);
	}
	

}
