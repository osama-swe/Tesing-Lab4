btn_click = function(){
    var num1 = parseInt(document.getElementById("firstnum").value)
    var num2 = parseInt(document.getElementById("secondnum").value)
    console.log(num1)
    console.log(num2)
    document.getElementById("resbox").hidden = false
    document.getElementById("add").innerText = num1 + num2
    document.getElementById("sub").innerText = num1 - num2
    document.getElementById("mult").innerText = num1 * num2
    document.getElementById("divide").innerText = num1 / num2
}

reset_click = function(){
    document.getElementById("resbox").hidden = true
    document.getElementById("add").innerText = ""
    document.getElementById("sub").innerText = ""
    document.getElementById("mult").innerText = ""
    document.getElementById("divide").innerText = ""
}