using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class MovingBackground : MonoBehaviour
{
    public float speed; //moving speed
    public float clamPos; //Clamping Position

     [HideInInspector]public Vector3 startPos; //starting point

    // Start is called before the first frame update
    void Start()
    {
        startPos = transform.position;
    }

    // Update is called once per frame
    void FixedUpdate()
    {
        float newPosition = Mathf.Repeat(Time.time * speed, clamPos);
        transform.position = startPos + Vector3.up * newPosition;
    }
}
