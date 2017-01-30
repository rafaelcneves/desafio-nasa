package com.rafael.desafio;

public class Nasa {
    final int MAX_X_POSITION = 4;
    final int MAX_Y_POSITION = 4;
    final int MIN_X_POSITION = 0;
    final int MIN_Y_POSITION = 0;

    int x, y;
    char orientation;
    String moves;

    public Nasa(String moves) {
        x = 0;
        y = 0;
        orientation = 'N';
        this.moves = moves;
    }

    public String getPosition() throws Exception {
        if (isValidPosition()) {
            return "("+ this.x +", "+ this.y +", "+ this.orientation +")";
        } else {
            throw new Exception("Out of bounds");
        }
    }

    public boolean isValidPosition() {
        return y >= MIN_Y_POSITION &&
            y <= MAX_Y_POSITION &&
            x >= MIN_X_POSITION &&
            x <= MAX_X_POSITION;
    }

    public void execute() throws Exception {
        for (char move : moves.toCharArray()) {
            switch (move) {
                case 'M':
                    move();
                    break;
                case 'R':
                    turnRight();
                    break;
                case 'L':
                    turnLeft();
                    break;
                default:
                    throw new Exception("Invalid move");
            }
        }
    }

    public void move() {
        switch (orientation) {
            case 'N':
                y++;
                break;
            case 'S':
                y--;
                break;
            case 'W':
                x--;
                break;
            case 'E':
                x++;
                break;
        }
    }

    public void turnRight() {
        switch (orientation) {
            case 'N':
                orientation = 'E';
                break;
            case 'S':
                orientation = 'W';
                break;
            case 'W':
                orientation = 'N';
                break;
            case 'E':
                orientation = 'S';
                break;
        }
    }

    public void turnLeft() {
        switch (orientation) {
            case 'N':
                orientation = 'W';
                break;
            case 'S':
                orientation = 'E';
                break;
            case 'W':
                orientation = 'S';
                break;
            case 'E':
                orientation = 'N';
                break;
        }
    }
}
