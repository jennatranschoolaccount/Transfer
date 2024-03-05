//Sarah Zhang
class Ball {
  int x, y, w, speedX, speedY, health, lives;
  PImage ball;
  Timer jumpTimer;
  
  boolean connected;
  float g;

  Ball() {
    x = 100;
    y = 100;
    w = 32;
    h = 32;
    ball = loadImage("(MM)Ball.png");

    speedX = 0;
    speedY = 0;
    //jumpTimer = new Timer(100);
    
    connected = false;
    g = 0.6;
  }
  
void land (float destY) {
  speedY = 0;
  connected = true;
  y = destY - h;
}

void update() {
  if (left) {
    speedX = -2;
  }
  if (right) {
    speedX = 2;
  }
  if (!left && !right) {
    speedX=0;
  } else if (left && right) {
    speedX=0;
  }
  if (up && connected == true) {
    speedY = -15;
    connected = false;
  }
  
  if (connected == false) {
    speedY += g; // Apply gravity (when not on platform)
  }
  
  if (y > height) {
    y = 0;
    speedY = 0;
  }
  x += speedX;
  y += speedY;
}

  void display() {
    imageMode(CENTER);
    ball.resize(w, w);
    image(ball, x, y);
  }
