const nums = document.querySelectorAll("input")
const form = document.querySelector("form")
const fademsg = document.querySelector('.fade-out-element');
const button1 = document.querySelector("#btnn1")
const button2 = document.querySelector("#btnn2")
const button3 = document.querySelector("#btnn3")
const alermsg = document.querySelector("#alermsg")
const msglog = document.querySelector("#log")
const pinform = document.querySelector("#pinform")
const date = new Date();
const pin = "1qaz";
let inpin = "";
let larmStatus = 1;
let audio = new Audio();



const firelarm = () => {
    console.log("larmljud", inpin)
    audio.src = "emergency-alarm-with-reverb-29431.mp3";
    //audio.play()
    msgHandler("FIREALRM")
   
}

const thieflarm = () => {
    console.log("larmljud", larmStatus)
    audio.src = "clock-alarm-8761.mp3";
    //audio.play()
    msgHandler("THIEFLARM")
}


const larm = () => {
    console.log("larmljud", inpin)
    firelarm()
    thieflarm()
}


const msgHandler = (msg) => {
    msglog.innerHTML +=  "<h6>" + date + " -- " + msg + "</h6>";
}



const checkPin = () => {
    if (pin === inpin) {
        button1.disabled = true
        button2.disabled = true
        button3.disabled = true
        msgHandler("LARM function is INACTIVAT")
    }else
        msgHandler("LARM function is still ACTIV")



}


const loopPin = nums.forEach((num, index) => {
    num.dataset.id = index



    num.addEventListener('keyup', () => {
        if (num.value.length === 1) {
            inpin += num.value
            
            checkPin()
            console.log(nums[nums.length - 1].value.length)
            if (nums[nums.length - 1].value.length == 1) {
            //alert('Hello there, sdsdsI am being submitted');
            
            }   
            //console.log(nums[nums.length - 1].value.length)
            nums[parseInt(num.dataset.id) + 1].focus()
            

        }

    })
})


