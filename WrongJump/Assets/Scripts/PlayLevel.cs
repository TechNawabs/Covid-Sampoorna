using System.Collections;
using System.Collections.Generic;
using UnityEngine.SceneManagement;
using UnityEngine;

public class PlayLevel : MonoBehaviour
{
    private void OnMouseEnter()
    {
        GetComponent<Renderer>().material.color = Color.green;
        GetComponent<AudioSource>().Play();
    }

    private void OnMouseUp()
    {
        SceneManager.LoadScene(2);
    }

    private void OnMouseExit()
    {
        GetComponent<Renderer>().material.color = Color.white;
    }
}
