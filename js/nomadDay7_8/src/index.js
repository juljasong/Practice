const taskForm = document.querySelector(".task-form");
const taskInput = taskForm.querySelector("input");
const pendingList = document.querySelector(".pending-list");
const finishedList = document.querySelector(".finished-list");

const PENDING_LS = "PENDING";
const FINISHED_LS = "FINISHED";

let pendingTasks = [];
let finishedTasks = [];

function init() {
  loadTasks();
  taskForm.addEventListener("submit", handleSubmit);
}

function loadTasks() {
  const loadedPending = localStorage.getItem(PENDING_LS);
  const loadedFinished = localStorage.getItem(FINISHED_LS);

  if (loadedPending !== null && loadedFinished === null) {
    const parsedPending = JSON.parse(loadedPending);
    parsedPending.forEach(function(pending) {
      paintPendingTask(pending.text);
    }); 
  } else if (loadedPending === null && loadedFinished !== null) {
    const parsedFinished = JSON.parse(loadedFinished);
    parsedFinished.forEach(function(finish) {
      paintFinishedTask(finish.text);
    }); 
  } else if (loadedPending !== null && loadedFinished !== null) {
    const parsedPending = JSON.parse(loadedPending);
    parsedPending.forEach(function(pending) {
      paintPendingTask(pending.text);
    }); 
    const parsedFinished = JSON.parse(loadedFinished);
    parsedFinished.forEach(function(finish) {
      paintFinishedTask(finish.text);
    }); 
  }
}

function handleSubmit(event) {
  event.preventDefault(); //  submit 이벤트 외의 별도의 브라우저 행동을 막음
  const task = taskInput.value;
  paintPendingTask(task);
  taskInput.value = "";
}

function paintPendingTask(text) {
  const li = document.createElement("li");
  const newId = pendingTasks.length + 1;
  const delBtn = document.createElement("button");
  delBtn.innerHTML = "❎";
  delBtn.addEventListener("click", deletePendingTask);
  const ptfBtn = document.createElement("button");
  ptfBtn.innerHTML = "✅";
  ptfBtn.addEventListener("click", pendingToFinished);
  const line = document.createElement("span");
  line.innerText = text + ` `;
  li.appendChild(line);
  li.appendChild(delBtn);
  li.appendChild(ptfBtn);
  li.id = newId;
  pendingList.appendChild(li);
  const taskObj = {
    text: text,
    id: newId
  }
  pendingTasks.push(taskObj);
  saveTasks(PENDING_LS, pendingTasks);
}

function paintFinishedTask(text) {
  const li = document.createElement("li");
  const delBtn = document.createElement("button");
  delBtn.innerHTML = "❎";
  delBtn.addEventListener("click", deleteFinishedTask);
  const ftpBtn = document.createElement("button");
  ftpBtn.innerHTML = "⏪";
  //ftpBtn.addEventListener("click", finishedToPending);
  const line = document.createElement("span");
  line.innerText = text + ` `;
  li.appendChild(line);
  li.appendChild(delBtn);
  li.appendChild(ftpBtn);
  finishedList.appendChild(li);
}

function saveTasks(LS, Tasks) {
  localStorage.setItem(LS, JSON.stringify(Tasks));
}


function deletePendingTask(event) {
  const btn = event.target;
  const li = btn.parentNode;
  pendingList.removeChild(li);

  const cleanTask = pendingTasks.filter(function(task){
      return task.id !== parseInt(li.id); // 리스트에 포함되지 않은 id 리턴 -> 삭제할 요소
  });
  pendingTasks = cleanTask;
  saveTasks(PENDING_LS, pendingTasks);
}

function deleteFinishedTask(event) {
  const btn = event.target;
  const li = btn.parentNode;
  finishedList.removeChild(li);

  const cleanTask = finishedTasks.filter(function(task){
      return task.id !== parseInt(li.id); // 리스트에 포함되지 않은 id 리턴 -> 삭제할 요소
  });
  finishedTasks = cleanTask;
  saveTasks(FINISHED_LS, finishedTasks);
}

function pendingToFinished() {}

function finishedToPending() {}


init();
