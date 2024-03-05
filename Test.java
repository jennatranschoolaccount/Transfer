// Mads McDougal, Sarah Zhang, Aayush Silwal, and Jenna Tran
// Friday, February 23rd, 2024 | PEMDASH Group Project

Platform p;

Platform [] platforms;

PImage startScreen;
PImage mainScreen;

//Jenna Tran and Sarah Zhang
Ball b1;
ArrayList<Spike> spikes = new ArrayList<Spike>();
//ArrayList<Laser> lasers = new ArrayList<Laser>();
ArrayList<Platform> platforms = new ArrayList<Platform>();
//ArrayList<PowUp> powups = new ArrayList<PowUp>();
int x, y, w, h; // Global Variable
int score;
int level;
boolean play, left, right, up, down;
//Timer spikeTimer, puTimer;

//Sarah Zhang
void setup() {
  size (600, 300);
  
  //LOOK HERE NEXT
  p = new Platform(300, 200);
  platforms = new Platform [2];
  platform[0] = new Platform(300, 100);
  
  left = false;
  right = false;
  up = false;
  down = false;
  play = false;
  b1 = new Ball(50, height - 50);
  //puTimer = new Timer(1500);
  //puTimer.start();
  //Mads McDougal
  startScreen = loadImage("(MM)startscreen.png");
  mainScreen = loadImage("(MM)backgroundGrass.png");
}

//Sarah Zhang
void draw() {
  if (!play) {
    startScreen();
  } else {
    //Mads McDougal
    //image(mainScreen, 0, 0);
    //Jenna Tran
    background (186, 203, 226);
    fill(255);
    rect(0, 270, 600, 100);
    rect(0, 0, 600, 100);
    fill(93, 102, 113);
    rect(0, 0, 600, 50);
    noCursor();
    textSize(20);
    fill(0);
    text("Score: " + score, 46, 30);
    text("Time: " + level, width/2, 30); // change to time later
    text("Health: " + b1.health, width - 60, 30);

    b1.update();
    p.display();
    
    for(int i = 0; i < platforms.length; i++) {
      platforms[i].display();
        if(rectangleIntersect(b1, platform[i])) {
          fill(255, 255, 0, 100);
          rect(0, 0, width, height);
          b1.land(p.y);
        } else {
          b1.connected = false;
        }
    }
    
    if (rectangleIntersect(b1, p)) {
      fill(255, 255, 0, 100);
      rect(0, 0, width, height);
      b1.land(p.y);
    } else {
      b1.connected = false;
    }

    //Jenna Tran
    // Distrubuting Spikes
    spikes.add(new Spike(600, 50));

    //if (spikeTimer.isFinished()) {
    //  spikes.add(new Spike(300, 50));
    //  spikeTimer.start();
    //}

    // Rendering Spikes
    //for (int i = 0; i < spikes.size(); i++) {
    //  Spike s = spikes.get(i);
    //  if (b1.intersect(s)) {
    //    b1.health -= s.diam/10;
    //    spikes.remove(s);
    //  }
    //  if (s.reachedLeft()) {
    //    spikes.remove(s);
    //    score -= s.diam;
    //  } else {
    //    s.display();
    //    s.move();
    //  }
    //}

    //Sarah Zhang
    //Adding Power Ups
    //if (puTimer.isFinished()) {
    //  powups.add(new PowUp(int(random(width)), - 100));
    //  puTimer.start();
    //}

    //Display Power Ups
    //for (int i = 0; i < powups.size(); i++) {
    //  PowUp pu = powups.get(i);
    //}

    //Jenna Tran and Sarah Zhang
    //Rendering Ball
    b1.display();
    //b1.move(100, 250);

    //Allowing a Jump Feature for the Ball
    b1.applyGravity();
    //b1.draw();
  }

  //Render Scoreboard
  //infoPanel();

  if (b1.health < 1) {
    gameOver();
  }
}

boolean rectangleIntersect(Ball r1, Platform r2){
  // Distance apart on x-axis
  float distanceX = (r1.x + r1.w/2) - (r2.x + r2.w/2);
  // Distance apart on y-axis
  float distanceY = (r1.y + r1.h/2) - (r2.y + r2.h/2);
  
  // The combined half-widths
  float combinedHalfW = r1.w/2 + r2.w/2;
  // The combined half-heights
  float combinedHalfH = r1.h/2 + r2.h/2;
  
  // Check for intersection on x-axis
  if (abs(distanceX) < combinedHalfW) {
    // Check for intersection on y-axis
    if (abs(distanceY) < combinedHalfH) {
      // They are intersecting
      return true;
    }
  }
  
}



//Jenna Tran, Sarah Zhang, and Mads McDougal
void startScreen() {
  image(startScreen, 0, 0);
  if (keyPressed || mousePressed) {
    play = true;
  }
}

//Sarah Zhang
//void instructions() {
//  background(0);
//  fill(255);
//  textAlign(CENTER);
//  textSize(18);
//  text("Instructions!:", width/2, 75);
//  text("", width/2, 125);
//  text("", width/2, 125);
//  text("Click ANY Key to Officially Begin the Game", width/2, 175);
//  if (keyPressed) {
//    play = true;
//  }
//}

//Sarah Zhang
void gameOver() {
  background(0);
  fill(255);
  textAlign(CENTER);
  textSize(40);
  text("Game Over", width/2, 75);
  text("Score: " + score, width/2, 125);
  text("Time: " + level, width/2, 175);
  noLoop();
}

//Sarah Zhang
void mousePressed() {
}

//Sarah Zhang
void keyPressed() {
  println("key:" + key);
  println("keyCode" + keyCode);
  if (keyPressed && key == ' ') {
    b1.jump();
    //b1.jumpTimer.start();
  }
}
