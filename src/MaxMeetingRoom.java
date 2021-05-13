import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MaxMeetingRoom {

	public static void main(String[] args) {
		int s[] = { 1, 3, 0, 5, 8, 5 };
		int f[] = { 2, 4, 6, 7, 9, 9 };
		List<Meeting> meetings = new ArrayList<>();
		for (int i = 0; i < s.length; i++) {
			meetings.add(new Meeting(s[i], f[i], i));
		}
		System.out.println(maxMeeting(meetings));
	}

	static class Meeting {
		int index;
		int start;
		int end;

		public Meeting(int start, int end, int index) {
			this.start = start;
			this.end = end;
			this.index = index;
		}
	}

	static int maxMeeting(List<Meeting> meetings) {
		Collections.sort(meetings, new Comparator<Meeting>() {
			@Override
			public int compare(Meeting o1, Meeting o2) {
				return Integer.compare(o1.end, o2.end);
			}
		});

		int result = 1;
		int prevMeetingEndTime = meetings.get(0).end;

		for (int i = 1; i < meetings.size(); i++) {
			if (meetings.get(i).start > prevMeetingEndTime) {
				result++;
				prevMeetingEndTime = meetings.get(i).end;
			}
		}
		return result;
	}
}
