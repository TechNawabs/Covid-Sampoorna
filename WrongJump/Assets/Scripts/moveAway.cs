using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class moveAway : MonoBehaviour
{
    public Vector3 destination;
    private Animation animation;

    void Start()
    {   
        animation = GetComponent<Animation>();
        StartCoroutine("backToStart");
    }

    void Update()
    {
        transform.position = Vector3.Lerp(transform.position, destination, Time.deltaTime);
    }

    IEnumerator backToStart(){
        yield return new WaitForSeconds(2000);
        if(transform.position == destination){
            animation.Play();
        }
    }
    
}
