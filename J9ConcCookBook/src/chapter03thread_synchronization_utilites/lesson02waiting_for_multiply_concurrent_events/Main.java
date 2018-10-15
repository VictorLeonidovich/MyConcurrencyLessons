package chapter03thread_synchronization_utilites.lesson02waiting_for_multiply_concurrent_events;

public class Main {

	public static void main(String[] args) {
		Videoconference conference = new Videoconference(10);
		Thread threadConference = new Thread(conference);
		threadConference.start();
		for (int i = 0; i < 10; i++) {
			Participant participant = new Participant(conference, "Participant " + i);
			Thread threadParticipant = new Thread(participant);
			threadParticipant.start();
		}
	}

}
