using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class OpenCredits : MonoBehaviour
{
    public Camera cam;
    public Transform target;
    public GameObject[] obj;

    private void OnMouseEnter()
    {
        GetComponent<Renderer>().material.color = Color.gray;
        GetComponent<AudioSource>().Play();
    }

    private void OnMouseUp()
    {
        cam.transform.position = Vector3.Lerp(cam.transform.position, target.position, 3.5f);
        for (int i = 0; i < obj.Length; i++)
        {
            obj[i].SetActive(true);
        }
    }

    private void OnMouseExit()
    {
        GetComponent<Renderer>().material.color = Color.white;
    }
}
