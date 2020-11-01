using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class CameraFollow1 : MonoBehaviour
{   
    public Transform trans;
    public float offset;

    // Update is called once per frame
    void LateUpdate()
    {
        //camera's position
        Vector3 temp = transform.position;
    
        //Camera's posiiton y is equal to player's position.y
        temp.y = trans.position.y;

        //Offset to camera's position y
        temp.y += offset;

        //setting back camera's temp position to camera's current position
        transform.position = temp;
    }
}
