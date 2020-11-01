using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class movement : MonoBehaviour
{
    private Rigidbody2D rigidbody;
    public Animator animator;
    public float speed;
    float dirX;
    bool facingRight = true;

    Vector3 localScale;

    void Start()
    {
        rigidbody = GetComponent<Rigidbody2D>();
        localScale = transform.localScale;
    }
    
    // Update is called once per frame
    void Update()
    {
        // float move = Input.GetAxis("Horizontal");
        // Debug.Log(move);

        // if(move == 0){
        //     animator.SetBool("isRunning", false);
        //     animator.SetFloat("Horizontal", 0.0f);
        // }
        
        // //Flip player left if LEFT is pressed.
        // if(move < 0){
        //     transform.eulerAngles = new Vector3(0, 180, 0);
        //     animator.SetFloat("Horizontal", move);
        //     animator.SetBool("isRunning", true);
        // } 
        // if(move > 0){
        //     transform.eulerAngles = new Vector3(0, 0, 0);
        //     animator.SetFloat("Horizontal", move);
        //     animator.SetBool("isRunning", true);
        // }      
        // Vector3 horizontal = new Vector3 (move, 0.0f, 0.0f);
        // transform.position = transform.position + horizontal * Time.deltaTime * speed; 
        dirX = Input.GetAxisRaw("Horizontal") * speed;

        if(Input.GetButtonDown("Jump") && rigidbody.velocity.y == 0)
            rigidbody.AddForce(Vector3.up * 700f);
        if(Mathf.Abs(dirX) > 0 && rigidbody.velocity.y == 0)
            animator.SetBool("isRunning", true);
        else
            animator.SetBool("isRunning", false);

        if(rigidbody.velocity.y ==0){
            animator.SetBool("isJumping", false);
            animator.SetBool("isFalling", false);
        }
        if(rigidbody.velocity.y > 0){
            animator.SetBool("isJumping", true);
        }
        if(rigidbody.velocity.y < 0){
            animator.SetBool("isJumping", false);
            animator.SetBool("isFalling", true);
        }
    }

    private void FixedUpdate(){
        rigidbody.velocity = new Vector2(dirX, rigidbody.velocity.y);
    }

    private void LateUpdate()
    {
        if(dirX > 0){
            facingRight = true;
        }
        else if (dirX < 0)
            facingRight = false;

        if(((facingRight) && (localScale.x < 0)) || ((!facingRight) && (localScale.x > 0)))
            localScale.x*= -1;
        transform.localScale = localScale;
    }
}
