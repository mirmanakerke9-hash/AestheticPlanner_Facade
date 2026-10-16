# Aesthetic Planner — Facade Design Pattern

## Project overview
Aesthetic Planner is a small Java console application that creates a daily plan. It organizes tasks, assigns them time slots, selects an aesthetic theme, and adds a motivational quote.

## Design pattern
The project implements the **Facade structural design pattern**. `AestheticPlannerFacade` offers one simplified method, `createDailyPlan(...)`, and coordinates the subsystem classes in the correct order.

## Class responsibilities
- `TaskManager`: validates and cleans the user's task list.
- `ScheduleManager`: assigns each task a time slot.
- `ThemeManager`: chooses the visual theme name.
- `MotivationManager`: selects a motivational quote.
- `AestheticPlannerFacade`: coordinates the subsystem and prints the final plan.
- `Main`: client code; it calls only the Facade.

The subsystem classes do not know that the Facade exists. They can also be used directly by advanced clients.

## How to run
Requires a JDK (Java 8 or newer).

From the project folder:

```bash
javac src/*.java
java -cp src Main
```

## Example output
The motivational quote is selected randomly, so that line may differ between runs.

```text
========== AESTHETIC PLANNER ==========
1. Tasks organized: [Morning skincare, Attend lectures, Study Java, Go for a walk, Read a book]
2. Schedule created from 09:00.
3. Aesthetic theme selected: Soft Pink
4. Daily motivation: "Small steps every day lead to big changes."

---------- YOUR DAILY PLAN ----------
Theme: Soft Pink
09:00 - Morning skincare
10:00 - Attend lectures
11:00 - Study Java
12:00 - Go for a walk
13:00 - Read a book
Quote: Small steps every day lead to big changes.
-------------------------------------
```

## Clean Code principles used
1. **Meaningful names:** names such as `createDailyPlan`, `TaskManager`, and `selectTheme` explain their purpose.
2. **Single Responsibility Principle:** each subsystem class has one main responsibility; the Facade coordinates instead of reimplementing their logic.
3. **Small, focused methods:** methods such as `prepareTasks`, `createSchedule`, and `printPlan` each do a focused job.
4. **Encapsulation:** subsystem objects are stored as private fields inside the Facade, so clients do not need to manage them.
5. **Error handling:** invalid or empty tasks and invalid time input are reported with a clear message instead of silently failing.
6. **Low coupling:** `Main` depends on the Facade API and does not instantiate or call subsystem classes directly.
7. **Subsystem independence:** subsystem classes have no reference to `AestheticPlannerFacade`, so they can still be used independently.

## Defense explanation
**What is Facade?** Facade is a structural design pattern that provides a simple interface to a complex subsystem.

**Where is Facade in this project?** `AestheticPlannerFacade` is the Facade. It calls the task, schedule, theme, and motivation managers in sequence.

**Why is it useful?** Without the Facade, `Main` would need to create and coordinate several objects. With the Facade, the client calls one method: `createDailyPlan(...)`.

**Why are there four subsystem classes?** Each handles a different part of preparing a daily plan: tasks, schedule, theme, and motivation.

**Does the Facade replace the subsystem classes?** No. It provides a convenient entry point, while the subsystem classes remain independent and usable directly.

**What happens if the tasks are empty?** `TaskManager` throws an `IllegalArgumentException`, and the Facade catches it and displays a readable error message.

## Suggested GitHub repository name
`aesthetic-planner-facade`
