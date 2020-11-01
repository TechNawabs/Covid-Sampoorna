using UnityEngine;
using System.Collections;

public class CameraFollow : MonoBehaviour {
    public Transform target;
    // Use this for initialization
    void FixedUpdate()
    {
        Vector3 targetPos = new Vector3(target.position.x, target.position.y, target.position.z);
        transform.position = targetPos;
    }
}