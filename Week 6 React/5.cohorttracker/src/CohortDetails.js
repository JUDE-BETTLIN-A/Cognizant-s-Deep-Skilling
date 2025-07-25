import styles from './CohortDetails.module.css'; // ✅ import CSS module

function CohortDetails(props) {
    const { cohort } = props;

    return (
        <div className={styles.box}> {/* ✅ Apply CSS class */}
            <h3 style={{ color: cohort.currentStatus === 'ongoing' ? 'green' : 'blue' }}>
                {cohort.cohortCode} - <span>{cohort.technology}</span>
            </h3>
            <dl>
                <dt>Started On</dt>
                <dd>{cohort.startDate}</dd>
                <dt>Current Status</dt>
                <dd>{cohort.currentStatus}</dd>
                <dt>Coach</dt>
                <dd>{cohort.coachName}</dd>
                <dt>Trainer</dt>
                <dd>{cohort.trainerName}</dd>
            </dl>
        </div>
    );
}

export default CohortDetails;
