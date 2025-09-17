import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;

public class MostPopularVideo {
    static class VideoInfo {
        String id;
        int views;

        VideoInfo(String id, int views) {
            this.id = id;
            this.views = views;
        }
    }

    public List<List<String>> mostPopularCreator(String[] creators, String[] ids, int[] views) {
        
        Map<String, Long> totalViews = new HashMap<>();
        Map<String, List<VideoInfo>> creatorVideos = new HashMap<>();
        long maxViews = 0;

        for (int i = 0; i < creators.length; i++) {
            String creator = creators[i];
            String id = ids[i];
            int viewsCount = views[i];

            long countTotal = totalViews.getOrDefault(creator, 0L) + viewsCount;
            totalViews.put(creator, countTotal);
            maxViews = Math.max(maxViews, countTotal);
            creatorVideos.putIfAbsent(creator, new ArrayList<>());
            creatorVideos.get(creator).add(new VideoInfo(id, viewsCount));
        }

        List<List<String>> res = new ArrayList<>();
        for (String creator : creatorVideos.keySet()) {
            if (totalViews.get(creator) == maxViews) {
                VideoInfo bestVideo = null;
                for (VideoInfo video : creatorVideos.get(creator)) {
                    if (bestVideo == null || video.views > bestVideo.views
                            || (video.views == bestVideo.views && video.id.compareTo(bestVideo.id) < 0)) {
                                bestVideo = video;
                    }
                }
                res.add(List.of(creator,bestVideo.id));
            }
        }
        return res;
    }

}
