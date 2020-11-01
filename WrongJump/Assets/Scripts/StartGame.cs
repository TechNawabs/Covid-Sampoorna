using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class StartGame : MonoBehaviour
{
    public GameObject b;

    private void Start()
    {
        StartCoroutine("startWithDelay");
    }

    IEnumerator startWithDelay()
    {
        yield return new WaitForSeconds(3);
        b.SetActive(true);
    }
}
