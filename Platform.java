class Platform {
  float x, y, w, h;
  
  Platform(float startX, float startY){
    x = startX;
    y = startY;
    w = 100;
    h = 20;
  }
  
  void display(){
    fill(255, 0, 0);
    rect(x, y, w, h);
  }
}
