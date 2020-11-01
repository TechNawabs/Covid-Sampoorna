using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.SceneManagement;

public class PlayGame : MonoBehaviour
{
    private void OnMouseEnter()
    {
        GetComponent<Renderer>().material.color = Color.green;
        GetComponent<AudioSource>().Play();
    }

    private void OnMouseUp()
    {
        SceneManager.LoadScene(1);
    }

    private void OnMouseExit()
    {
        GetComponent<Renderer>().material.color = Color.white;
    }
}
