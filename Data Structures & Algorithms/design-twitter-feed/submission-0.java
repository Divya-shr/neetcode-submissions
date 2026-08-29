class Twitter {

    // userId -> users they follow
    private Map<Integer, Set<Integer>> following;

    // userId -> list of tweets
    private Map<Integer, List<Tweet>> tweets;

    // Global timestamp
    private int time;

    public Twitter() {
        following = new HashMap<>();
        tweets = new HashMap<>();
        time = 0;
    }

    public void postTweet(int userId, int tweetId) {

        tweets.putIfAbsent(userId, new ArrayList<>());

        tweets.get(userId).add(
            new Tweet(tweetId, time++)
        );
    }

    public List<Integer> getNewsFeed(int userId) {

        List<Integer> result = new ArrayList<>();

        // Max heap: newest tweet first
        PriorityQueue<TweetInfo> maxHeap =
            new PriorityQueue<>(
                (a, b) -> Integer.compare(
                    b.tweet.time,
                    a.tweet.time
                )
            );

        // Users whose tweets should appear in feed
        Set<Integer> users = new HashSet<>();

        users.add(userId);

        if (following.containsKey(userId)) {
            users.addAll(following.get(userId));
        }

        // Add each user's most recent tweet
        for (int user : users) {

            List<Tweet> userTweets = tweets.get(user);

            if (userTweets != null && !userTweets.isEmpty()) {

                int index = userTweets.size() - 1;

                maxHeap.offer(
                    new TweetInfo(user, index, userTweets.get(index))
                );
            }
        }

        // Get at most 10 most recent tweets
        while (!maxHeap.isEmpty() && result.size() < 10) {

            TweetInfo current = maxHeap.poll();

            result.add(current.tweet.id);

            // Move to this user's previous tweet
            if (current.index > 0) {

                int previousIndex = current.index - 1;

                List<Tweet> userTweets =
                    tweets.get(current.userId);

                maxHeap.offer(
                    new TweetInfo(
                        current.userId,
                        previousIndex,
                        userTweets.get(previousIndex)
                    )
                );
            }
        }

        return result;
    }

    public void follow(int followerId, int followeeId) {

        following.putIfAbsent(
            followerId,
            new HashSet<>()
        );

        following.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {

        if (following.containsKey(followerId)) {
            following.get(followerId).remove(followeeId);
        }
    }

    // Represents a tweet
    private static class Tweet {

        int id;
        int time;

        Tweet(int id, int time) {
            this.id = id;
            this.time = time;
        }
    }

    // Used by the heap
    private static class TweetInfo {

        int userId;
        int index;
        Tweet tweet;

        TweetInfo(int userId, int index, Tweet tweet) {
            this.userId = userId;
            this.index = index;
            this.tweet = tweet;
        }
    }
}