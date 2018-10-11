package 파트8_인터페이스;

public interface Tv {
	
	public int MIN_VOLUME = 0;
	public int MAX_VOLUME = 100;
   
	public void turnOn();
	public void turnOff();
	public void changeVolume(int volume);
	public void changeChannel(int channel);
}
