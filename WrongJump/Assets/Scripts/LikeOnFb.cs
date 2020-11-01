using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class LikeOnFb : MonoBehaviour
{
    private void OnMouseEnter()
    {
        GetComponent<Renderer>().material.color = Color.cyan;
        GetComponent<AudioSource>().Play();
    }

    private void OnMouseUp()
    {
        Application.OpenURL("https://www.facebook.com/technawabs/");
    }

    private void OnMouseExit()
    {
        GetComponent<Renderer>().material.color = Color.white;
    }
}
