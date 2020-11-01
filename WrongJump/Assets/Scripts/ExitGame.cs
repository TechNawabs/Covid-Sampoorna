using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class ExitGame : MonoBehaviour
{
    private void OnMouseEnter()
    {
        GetComponent<Renderer>().material.color = Color.gray;
        GetComponent<AudioSource>().Play();
    }

    private void OnMouseUp()
    {
        Application.Quit();
    }

    private void OnMouseExit()
    {
        GetComponent<Renderer>().material.color = Color.white;
    }
}
