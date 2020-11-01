using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class LikeOnGoogle : MonoBehaviour
{
    private void OnMouseEnter()
    {
        GetComponent<Renderer>().material.color = Color.red;
        GetComponent<AudioSource>().Play();
    }

    private void OnMouseUp()
    {
        Application.OpenURL("https://plus.google.com/108679822454639174758");
    }

    private void OnMouseExit()
    {
        GetComponent<Renderer>().material.color = Color.white;
    }
}
