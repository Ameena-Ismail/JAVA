public class Galaxy extends Phone implements Ringable{
	//constructor
	public Galaxy(String versionNumber, int batteryPercentage, String carrier, String ringTone) {
		super(versionNumber, batteryPercentage, carrier, ringTone);
	}
	@Override
	public String ring() {
		return "start "+this.getRingTone()+" Tone";
	}
	@Override
	public String unlock() {
		return "unlock "+this.getClass().toString()+this.toString();
	}
    @Override
	public void displayInfo() {
		System.out.println(this.getVersionNumber());
		System.out.println(this.getBatteryPercentage());
		System.out.println(this.getCarrier());
		System.out.println(this.getRingTone());
	}
}