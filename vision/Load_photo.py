import numpy as np
import cv2

cap = cv2.VideoCapture(0)
def onmouse(k,x,y,s,p):
    global hsv
    if k==1:   # left mouse, print pixel at x,y
        print(hsv[y,x])


while(True):
    # Capture frame-by-frame
    ret, frame = cap.read()

    # Our operations on the frame come here
    hsv = cv2.cvtColor(frame, cv2.COLOR_BGR2HSV)

    # Display the resulting frame
    lower_green = np.array([20, 190, 165])
    upper_green = np.array([30, 225, 220])
    mask = cv2.inRange(hsv, lower_green, upper_green)
    res = cv2.bitwise_and(frame,frame,mask=mask)
    cv2.imshow('orig',frame)
    cv2.imshow('fff',res)

    # Calibration
    # cv2.namedWindow("hsv")
    # cv2.setMouseCallback("hsv", onmouse)
    # cv2.imshow('hsv', hsv)
    
    if cv2.waitKey(1) & 0xFF == ord('q'):
        break

# When everything done, release the capture
cap.release()
cv2.destroyAllWindows()