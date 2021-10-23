using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class MoveTitle : MonoBehaviour
{
    public float speed;
    public float delay;
    public Transform finalPos;
    public GameObject[] gameObjects;

    void Update(){
        float step = speed * Time.deltaTime;
        transform.position = Vector3.MoveTowards(transform.position, finalPos.transform.position, step);
        if(transform.position == finalPos.transform.position)
            StartCoroutine("DisplayAll");
    }

    IEnumerator DisplayAll(){
        yield return(new WaitForSeconds(delay));
        for(int i=0; i < gameObjects.Length; i++){
            gameObjects[i].SetActive(true);
        }
    }
}