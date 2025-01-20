package org.imt.tournamentmaster.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GameDTO {

    public static class Player {
        private String username;
        private int rating;
        private String result;
        @JsonProperty("@id")
        private String id;

        // Getters and setters
        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public int getRating() {
            return rating;
        }

        public void setRating(int rating) {
            this.rating = rating;
        }

        public String getResult() {
            return result;
        }

        public void setResult(String result) {
            this.result = result;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }
    }

    private Player white;
    private Player black;
    private Accuracies accuracies;
    private String url;
    private long startTime;
    private long endTime;
    private String timeControl;
    private String rules;

    public static class Accuracies {
        private float white;
        private float black;

        // Getters and setters
        public float getWhite() {
            return white;
        }

        public void setWhite(float white) {
            this.white = white;
        }

        public float getBlack() {
            return black;
        }

        public void setBlack(float black) {
            this.black = black;
        }
    }

    // Getters and setters
    public Player getWhite() {
        return white;
    }

    public void setWhite(Player white) {
        this.white = white;
    }

    public Player getBlack() {
        return black;
    }

    public void setBlack(Player black) {
        this.black = black;
    }

    public Accuracies getAccuracies() {
        return accuracies;
    }

    public void setAccuracies(Accuracies accuracies) {
        this.accuracies = accuracies;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    public String getTimeControl() {
        return timeControl;
    }

    public void setTimeControl(String timeControl) {
        this.timeControl = timeControl;
    }

    public String getRules() {
        return rules;
    }

    public void setRules(String rules) {
        this.rules = rules;
    }

}